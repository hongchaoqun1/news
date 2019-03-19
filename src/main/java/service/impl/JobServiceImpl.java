package service.impl;/**
 * Create by hongcq on 2019/3/19
 */

import dao.JobMapper;
import models.DO.JobDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.JobService;

import java.util.List;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:45
 *@ClassName JobServiceImpl
 */
@Service
public class JobServiceImpl implements JobService{

    @Autowired(required = false)
    private JobMapper jobMapper;

    @Override
    public List<JobDO> getAllJob() {
        return jobMapper.getAllJob();
    }

    @Override
    public JobDO getJobById(Integer id) {
        return jobMapper.getJobById(id);
    }
}
