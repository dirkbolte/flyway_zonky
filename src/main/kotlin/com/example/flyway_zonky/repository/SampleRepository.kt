package com.example.flyway_zonky.repository

import com.example.flyway_zonky.entities.Sample
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface SampleRepository : CrudRepository<Sample, UUID>
