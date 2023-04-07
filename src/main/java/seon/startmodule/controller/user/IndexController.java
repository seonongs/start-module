package seon.startmodule.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import seon.startmodule.config.role.UserAuthorize;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@UserAuthorize
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("loginId", user.getUsername());
        model.addAttribute("loginRoles", user.getAuthorities());
        return "user/common/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "user/common/dashboard";
    }
    @ResponseBody
    @GetMapping("/userInfo")
    public Map<String, Object> userInfo(@AuthenticationPrincipal User user, HttpServletRequest request) {

        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("loginId", user.getUsername());
        userInfo.put("loginRoles", user.getAuthorities());

        HttpSession session = request.getSession();

        long maxInactiveInterval = session.getMaxInactiveInterval() * 1000L; //1800초 * 1000 해서 timestamp에 맞춤

        long creationTime = session.getCreationTime(); //세션 생성 timestamp

        long endTime = creationTime + maxInactiveInterval; //세션 종료 timestamp

        userInfo.put("endTime", endTime);
        logger.info("endTime: " + endTime);

        return userInfo;
    }

    @GetMapping("/setting")
    public String settingPage() {
        return "user/common/everybody";
    }

}
