package com.rodri.dev.workshopmongo.config;

import com.rodri.dev.workshopmongo.domain.Post;
import com.rodri.dev.workshopmongo.domain.User;
import com.rodri.dev.workshopmongo.dto.AuthorDto;
import com.rodri.dev.workshopmongo.dto.CommentDto;
import com.rodri.dev.workshopmongo.repository.PostRepository;
import com.rodri.dev.workshopmongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmal.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP, Abraços!", new AuthorDto(maria));

        CommentDto c1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(maria));
        post1.getComments().add(c1);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.save(post1);

        maria.getPosts().add(post1);

    }

}
