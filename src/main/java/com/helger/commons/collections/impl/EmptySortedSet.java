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
package com.helger.commons.collections.impl;

import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.collections.iterate.EmptyIterator;
import com.helger.commons.lang.GenericReflection;

/**
 * Default implementation of an empty sorted set.
 *
 * @author Philip Helger
 */
public final class EmptySortedSet extends AbstractSet <Object> implements SortedSet <Object>
{
  private static final EmptySortedSet INSTANCE = new EmptySortedSet ();

  private EmptySortedSet ()
  {}

  @Override
  @Nonnull
  public Iterator <Object> iterator ()
  {
    return new EmptyIterator <Object> ();
  }

  @Override
  @Nonnegative
  public int size ()
  {
    return 0;
  }

  @Override
  public boolean isEmpty ()
  {
    return true;
  }

  @Override
  public boolean contains (final Object obj)
  {
    return false;
  }

  @Nullable
  public Comparator <Object> comparator ()
  {
    return null;
  }

  @Nonnull
  public SortedSet <Object> subSet (final Object fromElement, final Object toElement)
  {
    return this;
  }

  @Nonnull
  public SortedSet <Object> headSet (final Object toElement)
  {
    return this;
  }

  @Nonnull
  public SortedSet <Object> tailSet (final Object fromElement)
  {
    return this;
  }

  @Nullable
  public Object first ()
  {
    return null;
  }

  @Nullable
  public Object last ()
  {
    return null;
  }

  // Preserves singleton property
  @Nonnull
  private Object readResolve ()
  {
    return INSTANCE;
  }

  @Nonnull
  public static <ELEMENTTYPE> SortedSet <ELEMENTTYPE> getInstance ()
  {
    return GenericReflection.<EmptySortedSet, SortedSet <ELEMENTTYPE>> uncheckedCast (INSTANCE);
  }
}
