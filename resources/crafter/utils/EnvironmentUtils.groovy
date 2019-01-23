/*
 * Copyright (C) 2007-2019 Crafter Software Corporation. All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package utils

import java.nio.file.Path
import java.nio.file.Paths

class EnvironmentUtils {

    /**
     * Returns the value of an environment variable.
     */
    static String getEnv(varName) {
        def env = System.getenv()

        return env[varName]
    }

    /**
     * Returns the URL of the Tomcat.
     */
    static String getTomcatUrl() {
        def port = getEnv('TOMCAT_HTTP_PORT')
        def url = "http://localhost:${port}"

        return url
    }

    /**
     * Returns the URL of the Deployer.
     */
    static String getDeployerUrl() {
        def port = getEnv('DEPLOYER_PORT')
        def url = "http://localhost:${port}"

        return url
    }

    /**
     * Returns the environment name (either authoring or delivery).
     */
    static String getEnvironmentName() {
        return getEnv("ENVIRONMENT_NAME")
    }

    /**
     * Returns the home folder for the Crafter installation.
     */
    static Path getCrafterHomeFolder() {
        return Paths.get(getEnv("CRAFTER_HOME"))
    }

    /**
     * Returns the bin folder for the Crafter installation.
     */
    static Path getCrafterBinFolder() {
        return getCrafterHomeFolder().resolve("bin")
    }

    /**
     * Returns the data folder for the Crafter installation.
     */
    static Path getCrafterDataFolder() {
        return getCrafterHomeFolder().resolve("data")
    }

    /**
     * Returns the backups folder for the Crafter installation.
     */
    static Path getCrafterBackupsFolder() {
        return getCrafterHomeFolder().resolve("backups")
    }

    /**
     * Returns the upgrade folder inside the bin.
     */
    static Path getUpgradeBinFolder() {
        return Paths.get(getEnv("UPGRADE_HOME"))
    }

    /**
     * Returns the tmp folder used for the upgrade
     */
    static Path getUpgradeTmpFolder() {
        return Paths.get(getEnv("UPGRADE_TMP_DIR"))
    }

    /**
     * Return true if the script should run in download grapes only mode.
     */
    static boolean isDownloadGrapesOnlyMode() {
        def downloadGrapesOnly = System.getProperty("mode.downloadGrapesOnly")
        if (downloadGrapesOnly) {
            return Boolean.parseBoolean(downloadGrapesOnly)
        } else {
            return false
        }
    }

}
