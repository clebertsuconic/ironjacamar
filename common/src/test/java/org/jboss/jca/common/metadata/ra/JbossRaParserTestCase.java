/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.common.metadata.ra;

import org.jboss.jca.common.metadata.jbossra.JbossRa;
import org.jboss.jca.common.metadata.jbossra.JbossRaParser;
import org.jboss.jca.common.metadata.jbossra.jbossra10.JbossRa10;
import org.jboss.jca.common.metadata.jbossra.jbossra20.RaConfigProperty;

import java.io.File;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 *
 * A RaParserTestCase.
 *
 * @author <a href="stefano.maestri@jboss.com">Stefano Maestri</a>
 *
 */
public class JbossRaParserTestCase
{
   /**
    * shouldParseJbossRa10WithSingleProperty
    * @throws Exception in case of error
    */
   @Test
   public void shouldParseJbossRa10WithSingleProperty() throws Exception
   {
      //given
      File xmlFile = new File(Thread.currentThread().getContextClassLoader()
            .getResource("jboss-ra-1.0-single-attribute.xml").toURI());
      JbossRaParser parser = new JbossRaParser();
      //when
      JbossRa jbossRa = parser.parse(xmlFile);
      //then
      assertThat(jbossRa, instanceOf(JbossRa10.class));
      assertThat(jbossRa.getRaConfigProperties().size(), is(1));
      assertThat(
            jbossRa
                  .getRaConfigProperties()
                  .get(0)
                  .equals(
                        RaConfigProperty.buildRaConfigProperty("ra-config-property-name0", "ra-config-property-value0",
                              "ra-config-property-type0", null)), is(true));

   }

   /**
    *
    * shouldParseJbossRa10WithOutProperties
    *
    * @throws Exception in case of error
    */
   @Test
   public void shouldParseJbossRa10WithOutProperties() throws Exception
   {
      //given
      File xmlFile = new File(Thread.currentThread().getContextClassLoader()
            .getResource("jboss-ra-1.0-no-attributes.xml").toURI());
      JbossRaParser parser = new JbossRaParser();
      //when
      JbossRa jbossRa = parser.parse(xmlFile);
      //then
      assertThat(jbossRa, instanceOf(JbossRa10.class));
      assertThat(jbossRa.getRaConfigProperties().size(), is(0));

   }

   /**
    *
    * shouldParseJbossRa10WithMultipleProperties
    *
    * @throws Exception in case of error
    */
   @Test
   public void shouldParseJbossRa10WithMultipleProperties() throws Exception
   {
      //given
      File xmlFile = new File(Thread.currentThread().getContextClassLoader()
            .getResource("jboss-ra-1.0-multiple-attributes.xml").toURI());
      JbossRaParser parser = new JbossRaParser();
      //when
      JbossRa jbossRa = parser.parse(xmlFile);
      //then
      assertThat(jbossRa, instanceOf(JbossRa10.class));
      assertThat(jbossRa.getRaConfigProperties().size(), is(2));
      assertThat(
            jbossRa
                  .getRaConfigProperties()
                  .get(0)
                  .equals(
                        RaConfigProperty.buildRaConfigProperty("ra-config-property-name0", "ra-config-property-value0",
                              "ra-config-property-type0", null)), is(true));
      assertThat(
            jbossRa
                  .getRaConfigProperties()
                  .get(1)
                  .equals(
                        RaConfigProperty.buildRaConfigProperty("ra-config-property-name1", "ra-config-property-value1",
                              "ra-config-property-type1", null)), is(true));
   }

   //   @Test
   //   public void shouldParseJbossRa10WithTonsOfProperties() throws Exception
   //   {
   //      //given
   //      File xmlFile = new File(Thread.currentThread().getContextClassLoader()
   //            .getResource("jboss-ra-1.0-tons-attributes.xml").toURI());
   //      JbossRaParser parser = new JbossRaParser();
   //      //when
   //      JbossRa jbossRa = parser.parse(xmlFile);
   //      //then
   //      assertThat(jbossRa, instanceOf(JbossRa10.class));
   //      assertThat(jbossRa.getRaConfigProperties().size(), is(200000));
   //      assertThat(
   //            jbossRa
   //                  .getRaConfigProperties()
   //                  .get(0)
   //                  .equals(
   //                        RaConfigProperty.buildRaConfigProperty("ra-config-property-name0",
   //   "ra-config-property-value0",
   //                              "ra-config-property-type0", null)), is(true));
   //      assertThat(
   //            jbossRa
   //                  .getRaConfigProperties()
   //                  .get(1)
   //                  .equals(
   //                        RaConfigProperty.buildRaConfigProperty("ra-config-property-name1",
   //"ra-config-property-value1",
   //                              "ra-config-property-type1", null)), is(true));
   //   }

}
