/**
 * Copyright OPS4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.wicket.it.samples;

import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;

import org.junit.Test;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.wicket.it.PaxWicketIntegrationTest;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SampleWebUiTest extends PaxWicketIntegrationTest {

    @Configuration
    public final Option[] configureAdditionalProvision() {
        return options(
            provision(mavenBundle().groupId("org.apache.servicemix.bundles")
                .artifactId("org.apache.servicemix.bundles.aopalliance").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-aop").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-beans").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-core").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-context").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-expression").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework").artifactId("spring-asm").versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework.osgi").artifactId("spring-osgi-core")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework.osgi").artifactId("spring-osgi-io")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework.osgi").artifactId("spring-osgi-extender")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.springframework.osgi").artifactId("spring-osgi-annotation")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket").artifactId("org.ops4j.pax.wicket.service")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.apache.aries").artifactId("org.apache.aries.util")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.apache.aries.proxy").artifactId("org.apache.aries.proxy")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.apache.aries.blueprint").artifactId("org.apache.aries.blueprint")
                .versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket.samples")
                .artifactId("org.ops4j.pax.wicket.samples.navigation").versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket.samples.plain")
                .artifactId("org.ops4j.pax.wicket.samples.plain.simple").versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket.samples.blueprint")
                .artifactId("org.ops4j.pax.wicket.samples.blueprint.simple").versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket.samples.blueprint.injection")
                .artifactId("org.ops4j.pax.wicket.samples.blueprint.injection.simple").versionAsInProject()),
            provision(mavenBundle().groupId("org.ops4j.pax.wicket.samples.springdm")
                .artifactId("org.ops4j.pax.wicket.samples.springdm.simple").versionAsInProject()),
            provision(mavenBundle().groupId("org.openengsb.wrapped").artifactId("net.sourceforge.htmlunit-all")
                .versionAsInProject()));
    }

    @Test
    public void testIfAllExamplesWhereLoaded_shouldBeAbleToAccessThemAll() throws Exception {
        // testNavigationApplication_shouldRender
        WebClient webclient = new WebClient();
        HtmlPage page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/navigation/");
        assertTrue(page.asText().contains("Homepage linking all OPS4J samples"));
        webclient.closeAllWindows();
        // testSamplePlainSimple_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/plain/simple");
        assertTrue(page.asText().contains("Welcome to the most simple pax-wicket application"));
        webclient.closeAllWindows();
        // testSampleBlueprintSimpleDefault_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/blueprint/simple/default");
        assertTrue(page.asText().contains("Welcome to the most simple pax-wicket application based on blueprint"));
        webclient.closeAllWindows();
        // testSampleBlueprintSimplePaxwicket_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/blueprint/simple/paxwicket");
        assertTrue(page.asText().contains("Welcome to the most simple pax-wicket application based on blueprint"));
        webclient.closeAllWindows();
        // testSampleBlueprintInjectionSimple_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/blueprint/injection/simple");
        assertTrue(page.asText().contains(
            "Welcome to the most simple pax-wicket injection application based on blueprint."));
        webclient.closeAllWindows();
        // testSampleSpringdmSimpleDefault_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/springdm/simple/default");
        assertTrue(page.asText().contains("Welcome to the most simple pax-wicket application based on springdm"));
        webclient.closeAllWindows();
        // testSampleSpringdmSimplePaxwicket_shouldRenderPage
        webclient = new WebClient();
        page = webclient.getPage("http://localhost:" + WEBUI_PORT + "/springdm/simple/paxwicket");
        assertTrue(page.asText().contains("Welcome to the most simple pax-wicket application based on springdm"));
        webclient.closeAllWindows();
    }

}
