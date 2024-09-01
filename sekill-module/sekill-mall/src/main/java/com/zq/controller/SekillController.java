package com.zq.controller;

import com.alibaba.fastjson.JSON;
import com.zq.dto.R;
import com.zq.dto.SeckillSkuRedisDto;
import com.zq.service.SekillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/sekill")
@Slf4j
public class SekillController {
    @Autowired
    SekillService seckillService;
    @RequestMapping("/skuInfo")
    public R getCurrentSeckillSessionSkus() throws Exception {
        List<SeckillSkuRedisDto> currentSeckillSkus = seckillService.getCurrentSeckillSkus();
        return R.ok().put("data", JSON.toJSONString(currentSeckillSkus));
    }
    @ResponseBody
    @RequestMapping("/seckillSessionBySkuId")
    public R getSeckillSessionBySkuId(@RequestBody Long skuId){
       log.info("seckillSessionBySkuId -----------------------");
        SeckillSkuRedisDto dto = seckillService.getSeckillSessionBySkuId(skuId);
        return  R.ok().put("data",JSON.toJSONString(dto));
    }
    /**
     * 秒杀抢购
     * killId=1_9&code=69d55333c9ec422381024d34fdfd3e85&num=1
     * @return
     */
    @GetMapping("/kill")
    public String seckill(@RequestParam("killId") String killId,
                          @RequestParam("code") String code,
                          @RequestParam("num") Integer num,
                          Model model){
        String orderSN = seckillService.kill(killId,code,num);
        model.addAttribute("orderSn",orderSN);
        return "success";
    }
}
