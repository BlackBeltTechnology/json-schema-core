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

package com.github.fge.jsonschema.messages;

import com.github.fge.jsonschema.report.ProcessingMessage;

/**
 * Messages used by JSON Reference processing exceptions
 */
public enum RefProcessingMessages
{
    URI_NOT_ABSOLUTE("URI is not absolute"),
    UNHANDLED_SCHEME("scheme not supported"),
    URI_NOT_JSON("content at URI is not valid JSON"),
    URI_IOERROR("cannot dereference URI (IOException)"),
    REF_LOOP("JSON Reference loop detected"),
    DANGLING_REF("unresolvable JSON Reference"),
    // FIXME: only used in -validator
    ILLEGAL_JSON_REF("illegal JSON Reference (fragment is not a JSON Pointer)"),
    ;

    private final String message;

    RefProcessingMessages(final String message)
    {
        this.message = message;
    }

    public ProcessingMessage asMessage()
    {
        return new ProcessingMessage().message(this);
    }

    @Override
    public String toString()
    {
        return message;
    }
}
