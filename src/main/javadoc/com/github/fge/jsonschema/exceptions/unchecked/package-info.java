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

/**
 * Unchecked processing exceptions
 *
 * <p>This class of exceptions is thrown in case of programming errors. The
 * most common situation is null inputs, but also malformed configuration
 * parameters.</p>
 *
 * <p>In spite of their name (all end with {@code Error}), these exceptions
 * do not extend {@link java.lang.Error} but {@link java.lang.RuntimeException}.
 * </p>
 */
package com.github.fge.jsonschema.exceptions.unchecked;
