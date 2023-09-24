package com.example.schoolwall.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController  //默认会将返回的对象数据转换成JSON格式
@RequestMapping("/answer")
public class AnswerController {

}
