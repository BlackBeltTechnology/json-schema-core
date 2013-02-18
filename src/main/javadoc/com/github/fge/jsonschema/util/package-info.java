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
 * Various utility classes
 *
 * <p>{@link com.github.fge.jsonschema.util.JsonLoader} contains various
 * methods to load JSON documents as {@link
 * com.fasterxml.jackson.databind.JsonNode} (schemas as well as instances to
 * validate).</p>
 *
 * <p>{@link com.github.fge.jsonschema.util.RhinoHelper} is in charge of all
 * regex validation: as the standard dictates ECMA 262 regexes, using {@link
 * java.util.regex} is out of the question. See this class' description for more
 * details.</p>
 *
 * <p>The {@link com.github.fge.jsonschema.util.NodeType} enum is a critical
 * part of the code. Its ability to determine the type of a {@link
 * com.fasterxml.jackson.databind.JsonNode} is an essential part of the
 * validation process.</p>
 */
package com.github.fge.jsonschema.util;
