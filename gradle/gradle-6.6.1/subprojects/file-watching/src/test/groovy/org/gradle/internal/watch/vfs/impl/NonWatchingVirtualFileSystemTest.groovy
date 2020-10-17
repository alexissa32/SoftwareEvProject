/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.watch.vfs.impl

import org.gradle.internal.vfs.impl.AbstractVirtualFileSystem
import spock.lang.Specification

class NonWatchingVirtualFileSystemTest extends Specification {

    def delegate = Mock(AbstractVirtualFileSystem)
    def nonWatchingVirtualFileSystem = new NonWatchingVirtualFileSystem(delegate)

    def "invalidates the virtual file system before and after the build"() {

        when:
        nonWatchingVirtualFileSystem.afterBuildStarted(retentionEnabled)
        then:
        1 * delegate.invalidateAll()
        0 * _

        when:
        nonWatchingVirtualFileSystem.beforeBuildFinished(retentionEnabled)
        then:
        1 * delegate.invalidateAll()
        0 * _

        where:
        retentionEnabled << [true, false]
    }
}
