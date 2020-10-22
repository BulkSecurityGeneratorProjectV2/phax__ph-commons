/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.jaxb.adapter;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Test class for class {@link AdapterLocalDateTime}.
 *
 * @author Philip Helger
 */
public final class AdapterLocalDateTimeTest
{
  @Test
  public void testUnmarshal ()
  {
    final AdapterLocalDateTime a = new AdapterLocalDateTime ();
    assertNull (a.unmarshal (null));
    assertNull (a.unmarshal (""));
    assertNull (a.unmarshal (" "));
    assertNull (a.unmarshal ("a"));
    assertNull (a.unmarshal ("a2020-01-01"));
    assertNull (a.unmarshal ("2020-01-01a"));
    assertNull (a.unmarshal ("2020-02-31"));
    assertNull (a.unmarshal ("2020- 01-01"));
    assertNull (a.unmarshal ("2020- 01 -01"));
    assertNull (a.unmarshal ("2020-01-01"));
    assertNull (a.unmarshal ("2020-01-01 T10:12:45.654"));
    assertNull (a.unmarshal ("2020-01-01T 10:12:45.654"));
    assertNotNull (a.unmarshal ("2020-01-01T10:12:45.654"));
    assertNotNull (a.unmarshal (" 2020-01-01T10:12:45.654"));
    assertNotNull (a.unmarshal ("2020-01-01T10:12:45.654 "));
    assertNotNull (a.unmarshal (" 2020-01-01T10:12:45.654 "));
  }
}
