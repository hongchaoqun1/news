package service;/**
 * Create by hongcq on 2019/3/19
 */

import models.DO.JobDO;

import java.util.List;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:45
 *@InterfaceName JobService
 */
public interface JobService {
    List<JobDO> getAllJob();

    JobDO getJobById(Integer id);
}
