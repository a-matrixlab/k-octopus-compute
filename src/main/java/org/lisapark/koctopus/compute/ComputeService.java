/* 
 * Copyright (C) 2019 Lisa Park, Inc. (www.lisa-park.net)
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
package org.lisapark.koctopus.compute;

import static spark.Spark.*;

/**
 *
 * @author alexmy
 */
public class ComputeService {

    public static void main(String[] args) {
        
        System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
        System.setProperty("org.eclipse.jetty.LEVEL", "OFF");

        
        // Set Server port
        int _port = 4567;
        String endPoint = "/k-octopus/compute";
        if (args.length > 0) {
            _port = Integer.valueOf(args[0]);
        }
        port(_port);
        // Map requests
        post(endPoint, (req, res) -> {
            return new HttpController().startProcessing(req, res);
        });
    }
}
