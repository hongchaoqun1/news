package dao;/**
 * Create by hongcq on 2019/3/19
 */

import models.DO.JobDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:16
 *@ClassName JobMapper
 */
public interface JobMapper {

    @Select("select * from t_job")
    List<JobDO> getAllJob();

    @Select("select * from t_job where id = #{jobId}")
    JobDO getJobById(Integer jobId);
}
