package cn.zh.es.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;


@Configuration
public class EsConfig {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    RestClient restClient = restHighLevelClient.getLowLevelClient();

//    IndexRequest request=new IndexRequest("spring-data", "elasticsearch", randomID())
//            .source(singletonMap("feature", "high-level-rest-client"))
//            .setRefreshPolicy(IMMEDIATE);
//    IndexResponse response = highLevelClient.index(request);

}
