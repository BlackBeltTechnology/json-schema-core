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

package com.github.fge.jsonschema.exceptions.unchecked;

import com.github.fge.jsonschema.report.ProcessingMessage;

/**
 * Class used in the event of JSON Reference input errors (null arguments, etc)
 */
public final class JsonReferenceError
    extends ProcessingError
{
    public JsonReferenceError(final String msg)
    {
        super(msg);
    }

    public JsonReferenceError(final ProcessingMessage message)
    {
        super(message);
    }
}
