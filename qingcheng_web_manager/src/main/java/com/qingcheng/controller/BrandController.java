package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.ResultInfo;
import com.qingcheng.pojo.Brand;
import com.qingcheng.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/pageFindAll")
    public PageResult<Brand> pageFindAll(Integer page,Integer size){
        System.out.println("page = " + page + ", size = " + size);
        if(page == null || page < 1){
            page=1;
        }
        if(size == null || size < 1){
            size=10;
        }
        return brandService.findPage(page,size);
    }

    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String,String> map){
        List<Brand> list = brandService.findList(map);
        return list;
    }

    @PostMapping("/findPage")
    public PageResult<Brand> findPage(Integer page,Integer size,@RequestBody Map<String, String> searchMap){
        System.out.println("page = " + page + ", size = " + size + ", searchMap = " + searchMap.get("name")+","+searchMap.get("letter"));
        if(page == null || page < 1){
            page=1;
        }
        if(size == null || size < 1){
            size=10;
        }
        return brandService.findPage(page,size,searchMap);
    }

    @GetMapping("/findById")
    public Brand findById(String id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public ResultInfo add(@RequestBody Brand brand){
        brandService.add(brand);
        return new ResultInfo();
    }

    @PostMapping("/update")
    public ResultInfo update(@RequestBody Brand brand){
        brandService.update(brand);
        return new ResultInfo();
    }

    @GetMapping("/del")
    public ResultInfo del(String id){
        brandService.del(id);
        return new ResultInfo();
    }
}
