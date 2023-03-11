package com.tripproject.totalCalories.controller;

import com.tripproject.totalCalories.domain.TotalCalories;
import com.tripproject.totalCalories.dto.request.CreateTotalCalorieRequest;
import com.tripproject.totalCalories.dto.request.YearMonthTotalCalorieRequest;
import com.tripproject.totalCalories.dto.response.BasicTotalCaloriesResponse;
import com.tripproject.totalCalories.service.TotalCalorieService;
import com.tripproject.user.application.port.in.response.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/totalCalorie")
@Controller
public class TotalCalorieRestController {

    private final TotalCalorieService totalCalorieService;

    @PostMapping("/save")
    public ResponseEntity<BasicTotalCaloriesResponse> createTotalCalorie(@AuthenticationPrincipal PrincipalDetails principal,
                                                                         CreateTotalCalorieRequest createTotalCalorieRequest){
        BasicTotalCaloriesResponse totalCalorie = totalCalorieService.createTotalCalorie(principal.getUser().getId(),createTotalCalorieRequest.toEntity());
        return ResponseEntity.ok(totalCalorie);
    }

    @GetMapping("/weight")
    public ResponseEntity<BasicTotalCaloriesResponse> getTodayTotalCalorie(@AuthenticationPrincipal PrincipalDetails principal){
        BasicTotalCaloriesResponse todayTotalCalorie = totalCalorieService.getTodayTotalCalorie(principal.getUser().getId());
        return ResponseEntity.ok(todayTotalCalorie);
    }

    @GetMapping("/calendarList")
    public ResponseEntity<Map<Integer, BasicTotalCaloriesResponse>> getTotalCalorieCalendar(@AuthenticationPrincipal PrincipalDetails principal,
                                                                                    YearMonthTotalCalorieRequest yearMonthTotalCalorieRequest){
        Map<Integer, BasicTotalCaloriesResponse> totalCalorieCalendar = totalCalorieService.getTotalCalorieCalendar(principal.getUser().getId(), yearMonthTotalCalorieRequest);
        return ResponseEntity.ok(totalCalorieCalendar);
    }

}
