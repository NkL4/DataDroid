/*
 * 2011 Foxykeep (http://www.foxykeep.com)
 *
 * Licensed under the Beerware License :
 * 
 *   As long as you retain this notice you can do whatever you want with this stuff. If we meet some day, and you think
 *   this stuff is worth it, you can buy me a beer in return
 */
package com.foxykeep.datadroidpoc.data.worker;

import java.io.IOException;
import java.net.URISyntaxException;

import android.os.Bundle;

import org.json.JSONException;

import com.foxykeep.datadroid.exception.RestClientException;
import com.foxykeep.datadroid.network.NetworkConnection;
import com.foxykeep.datadroid.network.NetworkConnection.NetworkConnectionResult;
import com.foxykeep.datadroidpoc.config.WSConfig;
import com.foxykeep.datadroidpoc.data.factory.CityListJsonFactory;

public class CityListWorker {

    public static Bundle start() throws IllegalStateException, IOException, URISyntaxException, RestClientException,
            JSONException {

        NetworkConnectionResult wsResult = NetworkConnection.retrieveResponseFromService(WSConfig.WS_CITY_LIST_URL,
                NetworkConnection.METHOD_GET);

        return CityListJsonFactory.parseResult(wsResult.wsResponse);
    }
}
