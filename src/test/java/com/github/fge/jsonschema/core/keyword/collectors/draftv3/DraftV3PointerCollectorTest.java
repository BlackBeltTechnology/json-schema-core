/*
 * Copyright (c) 2014, Francis Galiegue (fgaliegue@gmail.com)
 *
 * This software is dual-licensed under:
 *
 * - the Lesser General Public License (LGPL) version 3.0 or, at your option, any
 *   later version;
 * - the Apache Software License (ASL) version 2.0.
 *
 * The text of both licenses is available under the src/resources/ directory of
 * this project (under the names LGPL-3.0.txt and ASL-2.0.txt respectively).
 *
 * Direct link to the sources:
 *
 * - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
 * - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
 */

package com.github.fge.jsonschema.core.keyword.collectors.draftv3;

import com.github.fge.jsonschema.core.keyword.collectors.AbstractPointerCollectorTest;
import com.github.fge.jsonschema.core.keyword.collectors.DraftV3PointerCollectorDictionary;

import java.io.IOException;

public abstract class DraftV3PointerCollectorTest
    extends AbstractPointerCollectorTest
{
    protected DraftV3PointerCollectorTest(final String keyword)
        throws IOException
    {
        super(DraftV3PointerCollectorDictionary.get(), "draftv3", keyword);
    }
}
