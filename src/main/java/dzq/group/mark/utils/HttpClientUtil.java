package dzq.group.mark.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 请求微信小程序服务
 */
public class HttpClientUtil {

    private Map<String, String> paramMap = new HashMap<String, String>();

    public HttpClientUtil addParam(String key, String value) {
        paramMap.put(key, value);
        return this;
    }

    public String get(String url,Map<String,String> param) throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder(url);
        Optional.ofNullable(param).get().forEach((key, value) -> uriBuilder.addParameter(key, value));
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");
    }

    public String get(String url) throws IOException, URISyntaxException {
        return get(url, paramMap);
    }

}
