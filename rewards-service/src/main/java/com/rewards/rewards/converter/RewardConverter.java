package com.rewards.rewards.converter;

import com.rewards.rewards.dto.RewardDTO;
import com.rewards.rewards.entity.Category;
import com.rewards.rewards.entity.Reward;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RewardConverter {

    public RewardDTO toRewardDTO(Reward reward) {
        RewardDTO rewardDTO = new RewardDTO();
        if (reward.getCategory().getCategoryId() != null) {
            rewardDTO.setCategoryId(reward.getCategory().getCategoryId());
        }
        BeanUtils.copyProperties(reward, rewardDTO);
        return rewardDTO;
    }

    public Reward toRewardEntity(RewardDTO rewardDTO, Category category) {
        Reward reward = new Reward();
        reward.setCategory(category);
        BeanUtils.copyProperties(rewardDTO, reward);
        return reward;
    }

    public List<RewardDTO> toRewardDtoList(List<Reward> employeeList){
        return employeeList.stream().map(this::toRewardDTO).collect(Collectors.toList());
    }
}
