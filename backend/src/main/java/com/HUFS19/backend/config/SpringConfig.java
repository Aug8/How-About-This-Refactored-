package com.HUFS19.backend.config;

import com.HUFS19.backend.repository.category.CategoryRepository;
import com.HUFS19.backend.repository.category.CategoryRepositoryImp;
import com.HUFS19.backend.repository.chatRoom.ChatRoomRepository;
import com.HUFS19.backend.repository.chatRoom.ChatRoomRepositoryImp;
import com.HUFS19.backend.repository.comment.CommentRepository;
import com.HUFS19.backend.repository.comment.CommentRepositoryImp;
import com.HUFS19.backend.repository.message.MessageRepository;
import com.HUFS19.backend.repository.message.MessageRepositoryImp;
import com.HUFS19.backend.repository.product.ProductRepositoryImp;
import com.HUFS19.backend.repository.product.ProductRepository;
import com.HUFS19.backend.service.ProductService;
import com.HUFS19.backend.repository.productImg.ProductImgRepository;
import com.HUFS19.backend.repository.productImg.ProductImgRepositoryImp;
import com.HUFS19.backend.repository.snsType.SnsTypeRepository;
import com.HUFS19.backend.repository.snsType.SnsTypeRepositoryImp;
import com.HUFS19.backend.repository.tag.TagRepository;
import com.HUFS19.backend.repository.tag.TagRepositoryImp;
import com.HUFS19.backend.repository.user.UserRepository;
import com.HUFS19.backend.repository.user.UserRepositoryImp;
import com.HUFS19.backend.repository.userInfo.UserInfoRepository;
import com.HUFS19.backend.repository.userInfo.UserInfoRepositoryImp;
import com.HUFS19.backend.repository.userLike.UserLikeRepository;
import com.HUFS19.backend.repository.userLike.UserLikeRepositoryImp;
import com.HUFS19.backend.repository.userSns.UserSnsRepository;
import com.HUFS19.backend.repository.userSns.UserSnsRepositoryImp;
import com.HUFS19.backend.service.TagService;
import com.HUFS19.backend.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em=em;
    }
//
//    @Bean
//    public ProductService service(){
//        return new ProductService(productRepository(), productImgRepository());
//    }
//    @Bean
//    public UserService userService(){return new UserService(userRepository());}
//    @Bean
//    public TagService tagService(){return new TagService(tagRepository());}
   //Repository
    @Bean
    public CategoryRepository categoryRepository(){return new CategoryRepositoryImp(em);
    }
    @Bean
    public ChatRoomRepository chatRoomRepository(){return new ChatRoomRepositoryImp(em);
    }
    @Bean
    public CommentRepository commentRepository(){return new CommentRepositoryImp(em);
    }
    @Bean
    public MessageRepository messageRepository(){return  new MessageRepositoryImp(em);
    }
    @Bean
    public ProductRepository productRepository(){return  new ProductRepositoryImp(em);
    }
    @Bean
    public ProductImgRepository productImgRepository(){return new ProductImgRepositoryImp(em);
    }
    @Bean
    public SnsTypeRepository snsTypeRepository(){return new SnsTypeRepositoryImp(em);
    }
    @Bean
    public TagRepository tagRepository(){return new TagRepositoryImp(em);
    }
    @Bean
    public UserRepository userRepository(){return new UserRepositoryImp(em);
    }
    @Bean
    public UserInfoRepository userInfoRepository(){return new UserInfoRepositoryImp(em);
    }
    @Bean
    public UserLikeRepository userLikeRepository(){return new UserLikeRepositoryImp(em);
    }
    @Bean
    public UserSnsRepository userSnsRepository(){return new UserSnsRepositoryImp(em);
    }

}
