/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.datetime.PDTWebDateHelper;

/**
 * XML Adapter between OffsetTime and String. Use it in your binding file like
 * this:<br>
 * <code>&lt;xjc:javaType name="java.time.OffsetTime" xmlType="xsd:time" adapter="com.helger.jaxb.adapter.AdapterOffsetTime" /&gt;</code>
 *
 * @author Philip Helger
 * @since 10.0.0
 */
public class AdapterOffsetTime extends XmlAdapter <String, OffsetTime>
{
  private static final Logger LOGGER = LoggerFactory.getLogger (AdapterOffsetTime.class);

  @Override
  public OffsetTime unmarshal (@Nullable final String sValue)
  {
    if (sValue == null)
      return null;

    final String sTrimmed = sValue.trim ();
    OffsetTime ret = PDTWebDateHelper.getOffsetTimeFromXSD (sTrimmed);
    if (ret == null)
    {
      // OffsetTime is only possible if a zone offset is present.
      // Check if this would be a valid LocalTime and use UTC as fallback
      final LocalTime aLT = PDTWebDateHelper.getLocalTimeFromXSD (sTrimmed);
      if (aLT != null)
        ret = OffsetTime.of (aLT, ZoneOffset.UTC);
      else
        LOGGER.warn ("Failed to parse '" + sValue + "' to an OffsetTime");
    }
    return ret;
  }

  @Override
  public String marshal (@Nullable final OffsetTime aValue)
  {
    return PDTWebDateHelper.getAsStringXSD (aValue);
  }
}
