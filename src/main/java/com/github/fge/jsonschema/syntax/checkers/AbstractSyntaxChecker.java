/*
 * Copyright (c) 2013, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.fge.jsonschema.syntax.checkers;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.NodeType;
import com.github.fge.jackson.jsonpointer.JsonPointer;
import com.github.fge.jsonschema.exceptions.ExceptionProvider;
import com.github.fge.jsonschema.exceptions.InvalidSchemaException;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.messages.MessageBundle;
import com.github.fge.jsonschema.messages.MessageBundles;
import com.github.fge.jsonschema.report.ProcessingMessage;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.tree.SchemaTree;

import java.util.Collection;
import java.util.EnumSet;

/**
 * Base abstract syntax checker
 *
 * <p>Apart from providing a convenient base to create a syntax checker of your
 * own, it also provides message templates with the appropriate information and
 * a customized exception provider (throwing a {@link InvalidSchemaException}
 * instead of the base {@link ProcessingException}.</p>
 */
public abstract class AbstractSyntaxChecker
    implements SyntaxChecker
{
    private static final MessageBundle BUNDLE = MessageBundles.SYNTAX;

    private static final ExceptionProvider EXCEPTION_PROVIDER
        = new ExceptionProvider()
    {
        @Override
        public ProcessingException doException(final ProcessingMessage message)
        {
            return new InvalidSchemaException(message);
        }
    };

    /**
     * The keyword name
     */
    protected final String keyword;

    /**
     * The list of types this keyword can have
     */
    private final EnumSet<NodeType> types;

    /**
     * Main constructor
     *
     * @param keyword the keyword name
     * @param first the first valid type for this keyword's value
     * @param other other valid types for this keyword's value (if any)
     */
    protected AbstractSyntaxChecker(final String keyword, final NodeType first,
        final NodeType... other)
    {
        this.keyword = keyword;
        types = EnumSet.of(first, other);
    }

    @Override
    public final EnumSet<NodeType> getValidTypes()
    {
        return EnumSet.copyOf(types);
    }

    /**
     * Main syntax checking function
     *
     * <p>This method only checks that the keyword's type is of the correct
     * type, and reports an error if it isn't; if it is, it handles the rest
     * of syntax checking to {@link #checkValue(Collection, ProcessingReport,
     * SchemaTree)}.</p>
     *
     * @param pointers the list of JSON Pointers to fill (see description)
     * @param report the processing report to use
     * @param tree the schema
     * @throws InvalidSchemaException keyword is invalid
     */
    @Override
    public final void checkSyntax(final Collection<JsonPointer> pointers,
        final ProcessingReport report, final SchemaTree tree)
        throws ProcessingException
    {
        final JsonNode node = getNode(tree);
        final NodeType type = NodeType.getNodeType(node);

        if (!types.contains(type)) {
            report.error(newMsg(tree, "incorrectType").put("expected", types)
                .put("found", type));
            return;
        }

        checkValue(pointers, report, tree);
    }

    /**
     * Method which all syntax checkers extending this class must implement
     *
     * <p>At this point, it is known that the keyword's value has at least the
     * correct type.</p>
     *
     * @param pointers the list of JSON Pointers to fill (see description)
     * @param report the processing report to use
     * @param tree the schema
     * @throws InvalidSchemaException keyword is invalid
     */
    protected abstract void checkValue(final Collection<JsonPointer> pointers,
        final ProcessingReport report, final SchemaTree tree)
        throws ProcessingException;

    /**
     * Provide a new message for reporting purposes
     *
     * @param tree the schema tree
     * @param key the key in the syntax message bundle
     * @return a new {@link ProcessingMessage}
     * @see ProcessingMessage#message(Object)
     */
    protected final ProcessingMessage newMsg(final SchemaTree tree,
        final String key)
    {
        return BUNDLE.message(key).put("domain", "syntax")
            .put("schema", tree).put("keyword", keyword)
            .setExceptionProvider(EXCEPTION_PROVIDER);
    }

    /**
     * Convenience method to retrieve the keyword's value
     *
     * @param tree the tree to extract the keyword's value from
     * @return the keyword's value
     */
    protected final JsonNode getNode(final SchemaTree tree)
    {
        return tree.getNode().get(keyword);
    }
}
