package com.example.travelseeker.service;

import com.example.travelseeker.model.entities.UserEntity;
import com.example.travelseeker.model.entities.UserRoleEntity;
import com.example.travelseeker.model.enums.UserRoleEnum;
import com.example.travelseeker.repository.UserRepository;
import com.example.travelseeker.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InitService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;


    public InitService(UserRepository userRepository,
                       UserRoleRepository userRoleRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void Init() {
        initRoles();
        initAdminUsers();
        initClientUsers();
        //    initSellerUsers();
    }


    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity admin = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            UserRoleEntity client = new UserRoleEntity().setRole(UserRoleEnum.CLIENT);
            //   UserRoleEntity seller = new UserRoleEntity().setRole(UserRoleEnum.SELLER);

            userRoleRepository.save(admin);
            userRoleRepository.save(client);
            //   userRoleRepository.save(seller);
        }
    }

    public void initAdminUsers() {


        UserEntity userClient = new UserEntity().
                setUsername("AdminAdminov").
                setFirstName("Admin").
                setLastName("Adminov").
                setEmail("adminov@example.com").
                setAge(40).
                setRoles(userRoleRepository.findAll()).
                setCountry("Bulgaria").
                setPassword(passwordEncoder.encode("lazar123"));

        userRepository.saveAndFlush(userClient);


    }

    private void initClientUsers() {


        UserEntity userClient = new UserEntity().
                setUsername("ClientClientov").
                setFirstName("Client").
                setLastName("Clientov").
                setEmail("clientov@example.com").
                setAge(30).
                setRoles(userRoleRepository.findAll()).
                setCountry("Germany").
                setPassword(passwordEncoder.encode("lazar123"));

        userRepository.saveAndFlush(userClient);
    }


   /* private void initSellerUsers() {

        var sellerUser = userRoleRepository.findUserRoleEntityByRole(UserRoleEnum.SELLER).orElseThrow();

        var userSeller = UserEntity.builder()
                .username("SellerSellerov")
                .firstName("Seller")
                .lastName("Sellerov")
                .email("sellerov@example.com")
                .age(40)
                .roles(List.of(sellerUser))
                .country("Bulgaria")
                .password(passwordEncoder.encode("lazar123")).build();

        userRepository.save(userSeller);
    }
*/

}
