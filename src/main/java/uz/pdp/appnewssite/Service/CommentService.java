package uz.pdp.appnewssite.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appnewssite.entity.Comment;
import uz.pdp.appnewssite.entity.Post;
import uz.pdp.appnewssite.payload.ApiResponse;
import uz.pdp.appnewssite.payload.CommentDto;
import uz.pdp.appnewssite.repository.CommentRepository;
import uz.pdp.appnewssite.repository.PostRepository;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;


    public ApiResponse addCommet(CommentDto commentDto) {
        if (!commentRepository.existsByText(commentDto.getText())) {
            return new ApiResponse("Bunday text mavjud emas", false);
        }

        Optional<Post> optionalPost = postRepository.findById(commentDto.getPostId());
        if (!optionalPost.isPresent()) {
            return new ApiResponse("Bunday post mavjud emas", false);
        }
        Comment comment = new Comment(
                commentDto.getText(),
                optionalPost.get()
        );
        commentRepository.save(comment);
        return new ApiResponse("Comment saqlandi", true);
    }



    public ApiResponse editComment(Long id, CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (!optionalComment.isPresent()) {
            return new ApiResponse("Comment mavjud emas", false);
        }

        Optional<Post> optionalPost = postRepository.findById(commentDto.getPostId());
        if (!optionalPost.isPresent()) {
            return new ApiResponse("Bunday post mavjud emas", false);
        }

        Comment comment = optionalComment.get();
        comment.setText(commentDto.getText());
        comment.setPost(optionalPost.get());
        commentRepository.save(comment);

        return new ApiResponse("Comment tahrirlandi", true);
    }




    public ApiResponse deleteComment(Long id) {
        commentRepository.deleteById(id);
        return new ApiResponse("Comment deleted", true);
    }
}
