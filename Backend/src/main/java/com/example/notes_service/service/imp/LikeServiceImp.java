package com.example.notes_service.service.imp;

import com.example.notes_service.dto.LikeDto;
import com.example.notes_service.exception.APIException;
import com.example.notes_service.exception.ResourceNotFound;
import com.example.notes_service.model.Like;
import com.example.notes_service.repository.LikeRepository;
import com.example.notes_service.service.LikeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LikeServiceImp implements LikeService {
    private final LikeRepository likeRepository;
    private final ModelMapper modelMapper;

    public LikeServiceImp(LikeRepository likeRepository, ModelMapper modelMapper) {
        this.likeRepository = likeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LikeDto addLike(LikeDto likeDto) {
        if(likeRepository.existsByUserIdAndContentId(likeDto.getUserId(), likeDto.getContentId())) {
            throw new APIException(HttpStatus.BAD_REQUEST, "You have already liked this note!");
        }
        Like like = new Like();
        like.setContentId(likeDto.getContentId());
        like.setUserId(likeDto.getUserId());
        like.setCreatedAt(new Date());
        likeRepository.save(like);
        return modelMapper.map(like, LikeDto.class);
    }

    @Override
    public List<LikeDto> getLikeByContentId(String contentId) {
        List<Like> likes = likeRepository.getAllByContentId(contentId);
        return likes.stream()
                .map(like -> modelMapper.map(like, LikeDto.class))
                .toList();
    }

    @Override
    public void removeLike(String likeId) throws ResourceNotFound {
        Like like = likeRepository.findById(likeId).orElseThrow(() ->
                new ResourceNotFound("Like", "Id", likeId));
        likeRepository.delete(like);
    }
}
