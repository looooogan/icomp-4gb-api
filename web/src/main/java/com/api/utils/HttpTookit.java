package com.api.utils;//package com.mypro.utils;
//
//
//import java.io.IOException;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
///**
// * HTTP工具箱
// * @ClassName: HttpTookit
// * @Description:
// * @author: Jingh
// * @date: 2014年6月12日 上午11:17:08
// */
//public final class HttpTookit {
//
//    private static Log log = LogFactory.getLog(HttpTookit.class);
//
//    /**
//     * 执行一个HTTP GET请求，返回请求响应的HTML
//     *
//     * @param url                 请求的URL地址
//     * @param queryString 请求的查询参数,可以为null
//     * @param charset         字符集
//     * @param pretty            是否美化
//     * @return 返回请求响应的HTML
//     * @throws IOException
//     * @throws ClientProtocolException
//     */
//    public static String doGet(String url) throws ClientProtocolException, IOException {
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        try {
//            HttpGet httpget = new HttpGet(url);
//            log.debug("Executing request " + httpget.getRequestLine());
//
//            // Create a custom response handler
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//				@Override
//                public String handleResponse(
//                        final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        HttpEntity entity = response.getEntity();
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//
//
//
//            };
//            String responseBody = httpclient.execute(httpget, responseHandler);
//            log.debug("----------------------------------------");
//            log.debug(responseBody);
//            return responseBody;
//        } finally {
//            httpclient.close();
//        }
//    }
//}