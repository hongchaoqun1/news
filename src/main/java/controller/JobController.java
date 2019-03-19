package controller;

import models.DO.JobDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.JobService;
import utils.ResponseBean;

import java.util.List;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:48
 *@ClassName JobController
 */
@RequestMapping("/job")
@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    /**
     * 获取所有职位
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public ResponseBean getAllJob(){
        List<JobDO> jobDOS = jobService.getAllJob();
        return ResponseBean.ok(jobDOS);
    }

    /**
     * 根据id 获取一个job
     * @param id
     * @return
     */
    @RequestMapping("/byId")
    @ResponseBody
    public ResponseBean getJobById(Integer id){
        JobDO jobDO = jobService.getJobById(id);
        return ResponseBean.ok(jobDO);
    }



}
