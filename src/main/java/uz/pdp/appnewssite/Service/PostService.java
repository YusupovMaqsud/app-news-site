package uz.pdp.appnewssite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.entity.Post;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.PostDto;
import uz.pdp.appnewssite.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;


    public ApiResponse addPost(PostDto postDto) {
        if (!postRepository.existsByTitle(postDto.getTitle())) {
            return new ApiResponse( " Bunday post bor", false);
        }

        Post post = new Post(
                postDto.getTitle(),
                postDto.getText(),
                postDto.getUrl()
        );
        postRepository.save(post);

        return new ApiResponse("Post saqlandi", true);
    }



    public ApiResponse editPost(Long id, PostDto PostDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(!optionalPost.isPresent()){
        return new ApiResponse("Post mavjud emas", false);

        }
        Post post = optionalPost.get();
       post.setTitle(PostDto.getTitle());
       post.setText(PostDto.getText());
       post.setUrl(PostDto.getUrl());
        postRepository.save(post);

        return new ApiResponse("Post tahrirlandi", true);
    }




    public ApiResponse deletePost(Long id) {
        postRepository.deleteById(id);
        return new ApiResponse("Post deleted", true);
    }
}
