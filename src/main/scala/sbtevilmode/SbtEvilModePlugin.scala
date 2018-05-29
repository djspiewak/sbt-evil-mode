/*
 * Copyright 2018 Daniel Spiewak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sbtevilmode

import sbt._

object SbtEvilModePlugin extends AutoPlugin {

  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  object autoImport {
    implicit class EvilModeRichProject(val self: Project) extends AnyVal {
      def gitHubDependency(owner: String, repo: String, hash: String, name: Option[String] = None) = {
        val id = uri(s"git://github.com/$owner/$repo.git#$hash")
        val ref = name.map(ProjectRef(id, _)).getOrElse(RootProject(id))
        self.dependsOn(ref)
      }
    }
  }
}
