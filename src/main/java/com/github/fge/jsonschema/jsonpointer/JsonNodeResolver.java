package com.github.fge.jsonschema.jsonpointer;

import com.fasterxml.jackson.databind.JsonNode;

public final class JsonNodeResolver
    extends TokenResolver<JsonNode>
{
    private static final char ZERO = '0';

    public JsonNodeResolver(final ReferenceToken token)
    {
        super(token);
    }

    @Override
    public JsonNode get(final JsonNode node)
    {
        if (!node.isContainerNode())
            return null;
        final String raw = token.getRaw();
        return node.isObject() ? node.get(raw) : node.get(arrayIndexFor(raw));
    }

    /**
     * Return an array index corresponding to the given (raw) reference token
     *
     * <p>If no array index can be found, -1 is returned. As the result is used
     * with {@link JsonNode#get(int)}, we are guaranteed correct results, since
     * this will return {@code null} in this case.</p>
     *
     * @param raw the raw token, as a string
     * @return the index, or -1 if the index is invalid
     */
    private static int arrayIndexFor(final String raw)
    {
        /*
         * Empty? No dice.
         */
        if (raw.isEmpty())
            return -1;
        /*
         * Leading zeroes are not allowed in number-only refTokens for arrays.
         * But then, 0 followed by anything else than a number is invalid as
         * well. So, if the string starts with '0', return 0 if the token length
         * is 1 or -1 otherwise.
         */
        if (raw.charAt(0) == ZERO)
            return raw.length() == 1 ? 0 : -1;

        /*
         * Otherwise, parse as an int. If we can't, -1.
         */
        try {
            return Integer.parseInt(raw);
        } catch (NumberFormatException ignored) {
            return -1;
        }
    }
}