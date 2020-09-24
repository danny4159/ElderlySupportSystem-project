package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.network.request.HistorySupportApiRequest;
import com.example.elderly_support.model.network.response.HistorySupportApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historySupport")
public class HistorySupportApiController extends CrudController<HistorySupportApiRequest, HistorySupportApiResponse, HistorySupport>{
}
