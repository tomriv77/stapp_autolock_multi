/**
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Auto Lock (parent)
 *
 *  Author: Tom Rivera
 *  Date: August 2, 2016
 */

definition(
    name: "Auto Lock",
    namespace: "tomriv77/parent",
    author: "tomriv77",
    description: "Locks a deadbolt or lever lock after a time delay when the door sensor state is closed.",
    category: "Safety & Security",
    iconUrl: "http://cdn.device-icons.smartthings.com/Health%20&%20Wellness/health7-icn.png",
    iconX2Url: "http://cdn.device-icons.smartthings.com/Health%20&%20Wellness/health7-icn@2x.png",
    iconX3Url: "http://cdn.device-icons.smartthings.com/Health%20&%20Wellness/health7-icn@3x.png",)


preferences {
    page(name: "mainPage", install: true, uninstall: true, submitOnChange: true) {
        section {
            app(name: "altdChild", appName: "Auto Lock Config", namespace: "tomriv77/automations", title: "Configure New Lock", multiple: true)
            }
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    // nothing needed here, since the child apps will handle preferences/subscriptions
    // this just logs some messages for demo/information purposes
    log.debug "there are ${childApps.size()} child smartapps"
    childApps.each {child ->
        log.debug "child app: ${child.label}"
    }
}