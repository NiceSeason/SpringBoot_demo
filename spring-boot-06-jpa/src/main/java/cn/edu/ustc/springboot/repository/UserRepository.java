package cn.edu.ustc.springboot.repository;


import cn.edu.ustc.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
