package org.example.zhipudemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.zhipudemo.model.po.Chat;
import org.example.zhipudemo.model.po.History;

import java.util.List;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/5$ 21:03$
 * @Params: $
 * @Return $
 */
@Mapper
public interface ZhiPuMapper {
    /**
     * 获取历史对话消息
     */
//    @Select("select image_meg, question, answer from chat where room_id = #{roomId}")
    List<History> getHistory(@Param("roomId") Integer roomId);
    /**
     * 插入对话记录
     */
//    @Insert("insert into chat(id, image_meg, question, answer, room_id, create_time) VALUES (#{id},#{imageMeg},#{question},#{answer},#{roomId},#{createTime})")
    void insert(Chat chat);
}
