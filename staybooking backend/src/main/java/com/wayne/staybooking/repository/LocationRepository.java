package com.wayne.staybooking.repository;

import com.wayne.staybooking.model.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends ElasticsearchRepository<Location, Long>, CustomLocationRepository {
    List<Long> searchByDistance(double lat, double lon, String distance);
}
