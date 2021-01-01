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
package com.helger.commons.url;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public final class URLValidatorTest
{
  private static final String [] VALID1 = new String [] { "http://www.helger.com",
                                                          "http://www.helger.com/",
                                                          "https://www.helger.com/",
                                                          "http://www.helger.com/misc",
                                                          "http://www.helger.com/mis97",
                                                          "http://www.6x.to",
                                                          "http://1.2.3.4/56",
                                                          "http://www.helger.com/~joe",
                                                          "https://en-US.add-ons.mozilla.com/en-US/firefox/bookmarks/",
                                                          "http://en-US.www.mozilla.com/en-US/firefox/central/",
                                                          "http://en-US.fxfeeds.mozilla.com/en-US/firefox/livebookmarks/",
                                                          "http://en-US.www.mozilla.com/en-US/firefox/help/",
                                                          "http://en-US.www.mozilla.com/en-US/firefox/customize/",
                                                          "http://en-US.www.mozilla.com/en-US/firefox/community/",
                                                          "http://en-US.www.mozilla.com/en-US/firefox/about/",
                                                          "http://www.alchemysorcery.com",
                                                          "http://www.akanbar.com/",
                                                          "http://www.akitsuki.com/",
                                                          "http://www.btinternet.com/~duncan.jauncey/mud/",
                                                          "http://www.firstage.net/",
                                                          "http://www.avatar.co.uk/",
                                                          "http://banished.dentinmud.org",
                                                          "http://www.british-legends.com/",
                                                          "http://www.cardea-rpg.com/",
                                                          "http://dum.acc.umu.se/",
                                                          "http://www.elysium-rpg.com",
                                                          "http://www.godwars2.org",
                                                          "http://www.iconoclast.org/",
                                                          "http://www.karchan.org/karchan/index.html",
                                                          "http://www.nodeka.com/",
                                                          "http://www.phantasia4.com/",
                                                          "http://www.qrealm.com",
                                                          "http://scrymud.net/",
                                                          "http://games.world.co.uk/shades/",
                                                          "http://www.legacyofthexelnaga.co.uk",
                                                          "http://www.thresholdrpg.com/",
                                                          "http://www.ursha7.com",
                                                          "http://www.worldofantra.com",
                                                          "http://www.altavista.com/web/results?q=%22independent%2bdevelopment%22",
                                                          "http://a9.com/%22independent%2bdevelopment%22",
                                                          "http://search.aol.com/aolcom/search?query=%22independent%2bdevelopment%22",
                                                          "http://search.ask.com/web?q=%22independent%2bdevelopment%22",
                                                          "http://clusty.com/search?query=%22independent%2bdevelopment%22",
                                                          "http://gigablast.com/search?q=%22independent%2bdevelopment%22",
                                                          "http://www.google.com/search?num=10&amp;query=%22independent%2bdevelopment%22",
                                                          "http://search.lycos.com/?query=%22independent%2bdevelopment%22",
                                                          "http://search.msn.com/results.aspx?q=%22independent%2bdevelopment%22",
                                                          "http://search.yahoo.com/bin/search?p=%22independent%2bdevelopment%22",
                                                          "http://www.aboson.com/",
                                                          "http://www.abotmills.com/",
                                                          "http://www.absoluteappliances.com/",
                                                          "http://www.ajmadison.com/",
                                                          "http://www.appliancepartsonline.net/",
                                                          "http://www.appliancegardens.com/",
                                                          "http://www.theappliancepro.com/",
                                                          "http://www.appliancewarehousedirect.com",
                                                          "http://www.247appliances.co.uk/",
                                                          "http://www.austin-margarita-rentals.com/",
                                                          "http://www.authorizedappliance.com/",
                                                          "http://www.bamix-blender.co.uk/",
                                                          "http://www.bestmaytag.com/",
                                                          "http://www.biltongmakers.com/",
                                                          "http://www.theblenderplace.com",
                                                          "http://www.brilliantstore.com",
                                                          "http://www.absolute-shopping.com/",
                                                          "http://www.cayneshousewares.com/",
                                                          "http://www.inductionsystems.com/",
                                                          "http://www.clocktowerelectrics.co.uk",
                                                          "http://www.cnmdirect.co.uk",
                                                          "http://www.compactappliance.com/",
                                                          "http://www.envirosink.com",
                                                          "http://www.aafeders.com/",
                                                          "http://www.forumappliances.com/",
                                                          "http://www.fridgefreeze.com",
                                                          "http://www.futurofuturo.com/",
                                                          "http://www.iGalaxyAppliances.com",
                                                          "http://www.mason-blackpool.com",
                                                          "http://www.goldenembers.com",
                                                          "http://www.goodmans.net",
                                                          "http://www.appliance-depot.com/",
                                                          "http://health-fit.com/",
                                                          "http://www.highendappliance.com",
                                                          "http://www.homecareappliances.co.uk/",
                                                          "http://www.garbagedisposer.net/",
                                                          "http://www.iguanadirect.co.uk",
                                                          "http://www.jualdomestics.com/",
                                                          "http://www.kappco.co.uk/",
                                                          "http://www.klondikerf.com/",
                                                          "http://www.microfridge.com",
                                                          "http://www.mini-kitchen.com",
                                                          "http://www.mountainhighappliance.com/",
                                                          "http://www.lpappliances.com/",
                                                          "http://www.onlineappliancesales.com/",
                                                          "http://www.openchute.com",
                                                          "http://www.gasapplianceguide.co.uk/",
                                                          "http://www.rangecookersdirect.co.uk/",
                                                          "http://secondtek.com",
                                                          "http://www.selectappliance.com",
                                                          "http://www.Smallhome.com",
                                                          "http://www.smallappliance.com/",
                                                          "http://StovesAndMoreOnline.com",
                                                          "http://www.tanscorp.com.au",
                                                          "http://toastercentral.com",
                                                          "http://www.ukappliancedirect.co.uk",
                                                          "http://www.universal-akb.com/",
                                                          "http://www.urbanhomemaker.com/",
                                                          "http://www.us-appliance.com/",
                                                          "http://www.220voltappliances.com/",
                                                          "http://www.warnersstellian.com",
                                                          "http://we-sell-it.co.uk",
                                                          "http://www.qualitymatters.com",
                                                          "http://de.wikipedia.org/apple-touch-icon.png",
                                                          "http://de.wikipedia.org/favicon.ico",
                                                          "http://de.wikipedia.org/skins-1.5/monobook/headbg.jpg" };
  private static final String [] VALID2 = new String [] { "http://upload.wikimedia.org/wikipedia/commons/thumb/9/93/P_countries-lightblue.png/30px-P_countries-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/5/53/P_history-lightblue.png/30px-P_history-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/3/32/P_social_sciences-lightblue.png/30px-P_social_sciences-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/P_art-lightblue.png/30px-P_art-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/P_religion-lightblue.png/30px-P_religion-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/9/95/P_sport-lightblue.png/30px-P_sport-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/P_transport-lightblue.png/30px-P_transport-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/3/33/P_ps-lightblue.png/30px-P_ps-lightblue.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/e/ee/NicolaiBenderRasterNotonLive.jpg/110px-NicolaiBenderRasterNotonLive.jpg",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Feed-icon.svg/12px-Feed-icon.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Etna_eruzione_1669_platania.jpg/95px-Etna_eruzione_1669_platania.jpg",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/European_Central_Bank_041107.jpg/85px-European_Central_Bank_041107.jpg",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Sturgeon_Pond.jpg/95px-Sturgeon_Pond.jpg",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Wikimedia_Community_Logo.svg/20px-Wikimedia_Community_Logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Commons-logo.svg/18px-Commons-logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/3/38/Wiktionary-ico-de.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Wikibooks-logo.svg/21px-Wikibooks-logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Wikiquote-logo.svg/20px-Wikiquote-logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Wikiversity-logo.svg/20px-Wikiversity-logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Wikisource-logo.svg/20px-Wikisource-logo.svg.png",
                                                          "http://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Wikinews-logo.svg/26px-Wikinews-logo.svg.png",
                                                          "http://de.wikipedia.org/skins-1.5/monobook/user.gif",
                                                          "http://upload.wikimedia.org/wikipedia/de/b/bc/Wiki.png",
                                                          "http://de.wikipedia.org/skins-1.5/common/images/poweredby_mediawiki_88x31.png",
                                                          "http://de.wikipedia.org/images/wikimedia-button.png",
                                                          "http://www.regex-tester.de/tpl/img/back_head.jpg",
                                                          "http://www.regex-tester.de/tpl/img/logo.jpg",
                                                          "http://www.regex-tester.de/tpl/img/dot.gif",
                                                          "http://www.regex-tester.de/tpl/img/icon_p_u.png",
                                                          "http://www.regex-tester.de/tpl/img/btn_help.png",
                                                          "http://www.regex-tester.de/tpl/img/btn_regex.png",
                                                          "http://derstandard.at/css/dropshadow.png",
                                                          "http://derstandard.at/css/homeHaeusl.gif",
                                                          "http://derstandard.at/css/WhiteHalfCircle.png",
                                                          "http://derstandard.at/css/GreyHalfCircle.png",
                                                          "http://derstandard.at/css/derStandardBlau.png",
                                                          "http://derstandard.at/css/searchBack.gif",
                                                          "http://derstandard.at/css/searchLupie.gif",
                                                          "http://derstandard.at/css/arrow.gif",
                                                          "http://derstandard.at/img/site/bottom/registrierung.gif",
                                                          "http://derstandard.at/img/site/bottom/edit.gif",
                                                          "http://derstandard.at/img/site/bottom/logout.gif",
                                                          "http://derstandard.at/img/site/bottom/impressum.gif",
                                                          "http://derstandard.at/img/site/bottom/sales.gif",
                                                          "http://derstandard.at/img/site/bottom/archivsuche.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/bewoelkt-b.gif",
                                                          "http://livestat.derstandard.at/cgi-bin/ivw2/CP/Newsroom/ressort/I/1236519501653",
                                                          // "http://derstand.oewabox.at/cgi-bin/ivw/CP/RedCont/Homepage/Homepage/derStandard.at;CP/Newsroom/ressort?d=1236519501653&r=http%3A//derstandard.at/",
                                                          "http://derstandard.at/img/cont/lnk/artikel_093875.gif",
                                                          "http://images.derstandard.at/t/104/2009/03/08/1234588967928.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588334578.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588634485.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/05/1234582762660.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/08/1234589162973.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/08/1234588954751.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/06/1234586882580.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234587203557.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234587069437.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234587025340.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234586921286.jpg",
                                                          "http://images.derstandard.at/20080317/lupe_magenta_trans70.gif",
                                                          "http://images.derstandard.at/2008/12/22/1229808478347.gif",
                                                          "http://images.derstandard.at/t/150/2009/03/05/1234579441828.jpg",
                                                          "http://images.derstandard.at/t/150/2009/03/05/1234579483566.jpg",
                                                          "http://images.derstandard.at/t/150/2009/03/06/1234584217491.jpg",
                                                          "http://images.derstandard.at/t/150/2009/03/06/1234587455780.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234586926142.jpg",
                                                          "http://images.derstandard.at/t/110/2009/03/06/1234587299183.jpg",
                                                          "http://images.derstandard.at/t/110/2009/03/06/1234587316870.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588396870.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/04/1234575990869.jpg",
                                                          "http://images.derstandard.at/t/106/2008/12/19/1227397732823.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234585622824.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234583480984.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/06/1234584748102.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588605629.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234587078365.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234584742674.jpg",
                                                          "http://derstandard.at/img/border/hspacer.gif",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234585294583.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234585813001.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588045797.jpg",
                                                          "http://images.derstandard.at/t/104/2009/02/26/1234554579540.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/08/1234589025677.jpg",
                                                          "http://images.derstandard.at/t/106/2009/02/11/1234356057611.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/05/1234579239902.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/03/1234571941201.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234586795854.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234587373097.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234583123590.jpg",
                                                          "http://images.derstandard.at/t/112/2009/02/10/1234262258097.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588595605.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588359806.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588576904.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/08/1234589085176.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/05/1234582120793.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588204302.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234587044900.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234588053068.jpg",
                                                          "http://images.derstandard.at/2008/12/01/1227324513424.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/stark-bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/stark-bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/stark-bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/heiter-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/stark-bewoelkt-xs.gif",
                                                          "http://derstandard.at/img/cont/wetter/fcicons/bewoelkt-xs.gif",
                                                          "http://images.derstandard.at/t/106/2009/03/07/1234588037417.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/06/1234587102136.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234586710800.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234586685485.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/08/1234588943007.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/05/1234582618568.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234587268524.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/02/1234568560684.jpg",
                                                          "http://images.derstandard.at/t/106/2009/01/13/1231186243940.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234584571139.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/05/1234579444773.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/05/1234580168704.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/06/1234583873300.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234587211674.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/05/1234582749204.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234584051968.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234584791596.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/03/1234571324902.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/01/1234564565037.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/02/1234567199189.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234586196689.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/03/1234570036807.jpg",
                                                          "http://images.derstandard.at/t/106/2009/03/02/1234566636173.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234585166014.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/06/1234583979452.jpg",
                                                          "http://images.derstandard.at/t/112/2009/02/27/1234560179545.jpg",
                                                          "http://images.derstandard.at/t/104/2009/03/07/1234587976164.jpg",
                                                          "http://images.derstandard.at/t/112/2009/03/04/1234577421034.jpg",
                                                          "http://derstandard.nuggad.net/bk?nuggn=1072017547&nuggsid=1660588788&nuggtg=RedCont%2FHomepage%2FHomepage%2FderStandard.at%3BderStandard.at&nuggl=http%3A%2F%2Faustria1.adverserve.net%2FRealMedia%2Fads%2Fcap.cgi%3Fc%3Dnuggstandcook%26va%3DNUGGVARS%26e%3D1y%26randomNumber%3D225354598556395940" };
  private static final String [] INVALID = new String [] { "any string" };

  @Test
  public void testValid ()
  {
    for (final String sValid : VALID1)
      assertTrue ("Expected '" + sValid + "' to be valid", URLValidator.isValid (sValid));
    for (final String sValid : VALID2)
      assertTrue ("Expected '" + sValid + "' to be valid", URLValidator.isValid (sValid));
    for (final String sInvalid : INVALID)
      assertFalse ("Expected '" + sInvalid + "' to be invalid", URLValidator.isValid (sInvalid));
  }
}
