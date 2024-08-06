package com.wayne.staybooking.repository;

import co.elastic.clients.elasticsearch._types.DistanceUnit;
import co.elastic.clients.elasticsearch._types.aggregations.GeoDistanceAggregation;
import com.wayne.staybooking.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

public class CustomLocationRepositoryImpl implements CustomLocationRepository {
    private final String DEFAULT_DISTANCE = "50";
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public CustomLocationRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public List<Long> searchByDistance(double lat, double lon, String distance) {
        if (distance == null || distance.isEmpty()) {
            distance = DEFAULT_DISTANCE;
        }
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withFilter(new GeoDistanceQueryBuilder("geoPoint").point(lat, lon).distance(distance, DistanceUnit.Kilometers));

        SearchHits<Location> searchResult = elasticsearchOperations.search(queryBuilder.build(), Location.class);
        List<Long> locationIDs = new ArrayList<>();
        for (SearchHit<Location> hit : searchResult.getSearchHits()) {
            locationIDs.add(hit.getContent().getId());
        }
        return locationIDs;
    }
}
