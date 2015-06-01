/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.commons.error;

import java.text.Collator;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.compare.AbstractCollationComparator;

/**
 * Special comparator that compares based on an error ID
 *
 * @author Philip Helger
 * @param <DATATYPE>
 *        Data type
 */
@NotThreadSafe
public class ComparatorHasErrorID <DATATYPE extends IHasErrorID> extends AbstractCollationComparator <DATATYPE>
{
  /**
   * Comparator with default locale {@link Collator} and default sort order.
   */
  public ComparatorHasErrorID ()
  {
    super ();
  }

  /**
   * Comparator with default sort order and specified sort locale.
   *
   * @param aSortLocale
   *        The locale to use. May be <code>null</code>.
   */
  public ComparatorHasErrorID (@Nullable final Locale aSortLocale)
  {
    super (aSortLocale);
  }

  /**
   * Constructor with {@link Collator} using the default sort order
   *
   * @param aCollator
   *        The {@link Collator} to use. May not be <code>null</code>.
   */
  public ComparatorHasErrorID (@Nonnull final Collator aCollator)
  {
    super (aCollator);
  }

  @Override
  @Nullable
  protected String asString (@Nonnull final DATATYPE aObject)
  {
    return aObject.getErrorID ();
  }
}
