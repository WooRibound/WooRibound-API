package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.exception.NoWbUserException;
import com.wooribound.global.exception.NotEntityException;
import com.wooribound.global.util.AuthenticateUtil;
import com.wooribound.global.util.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService {

    @Value("${aws.s3.wbUser.folder}")
    String wbUserFolderName;

    private final S3Util s3Util;
    private final AuthenticateUtil authenticateUtil;
    private final ResumeRepository resumeRepository;
    private final WbUserRepository wbUserRepository;
    private final WorkHistoryRepository workHistoryRepository;

    @Override
    @Transactional
    public ResumeDTO getResume(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        WbUser wbUser = wbUserRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[WbUser, ID :" + userId + "]"));

        Resume resume = resumeRepository.findByUserId(wbUser.getUserId()).orElse(null);

        return ResumeDTO.builder()
                .userName(wbUser.getName())
                .userPhone(wbUser.getPhone())
                .userImg(resume != null ? resume.getUserImg() : "")
                .resumeEmail(resume != null ? resume.getResumeEmail() : "")
                .userIntro(resume != null ? resume.getUserIntro() : "")
                .build();
    }

    @Override
    @Transactional
    public ResumeDTO registerResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        WbUser wbUser = wbUserRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[WbUser, ID :" + userId + "]"));

        long resumeId = resumeRepository.getMaxResumeId().orElse(0L) + 1;

        String fileURL = s3Util.uploadFile(userImg, wbUserFolderName);

        try {
        Resume resume = Resume.builder()
                .resumeId(resumeId)
                .wbUser(wbUser)
                .userImg(fileURL)
                .resumeEmail(resumeEmail)
                .userIntro(userIntro)
                .build();

        Resume savedResume = resumeRepository.save(resume);


        return ResumeDTO.builder()
                .userName(savedResume.getWbUser().getName())
                .userPhone(savedResume.getWbUser().getPhone())
                .userImg(savedResume.getUserImg())
                .resumeEmail(savedResume.getResumeEmail())
                .userIntro(savedResume.getUserIntro())
                .build();

        } catch (Exception e) {
            // 트랜잭션 실패 시 업로드된 이미지 삭제
            s3Util.deleteFile(fileURL, wbUserFolderName);
            throw e;
        }
    }

    @Override
    @Transactional
    public ResumeDTO updateResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) throws IOException {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        WbUser wbUser = wbUserRepository.findById(userId)
                .orElseThrow(() -> new NotEntityException("[WbUser, ID :" + userId + "]"));

        Resume resume = resumeRepository.findByUserId(wbUser.getUserId())
                .orElseThrow(() -> new NotEntityException("[Resume]"));

        if (userImg != null) {
            // s3에서 파일 삭제
            s3Util.deleteFile(resume.getUserImg(), wbUserFolderName);

            // s3에 새로운 파일 업로드
            String fileURL = s3Util.uploadFile(userImg, wbUserFolderName);

            resume.setUserImg(fileURL);
        }

        resume.setResumeEmail(resumeEmail);
        resume.setUserIntro(userIntro);

        Resume savedResume = resumeRepository.save(resume);

        return ResumeDTO.builder()
                .userName(savedResume.getWbUser().getName())
                .userPhone(savedResume.getWbUser().getPhone())
                .userImg(savedResume.getUserImg())
                .resumeEmail(savedResume.getResumeEmail())
                .userIntro(savedResume.getUserIntro())
                .build();
    }

    @Override
    @Transactional
    public ResumeDetailDTO getWbUserResume(String userId) {
        WbUser byIdWbUser = wbUserRepository.findById(userId)
                .orElseThrow(() -> new NoWbUserException("해당 사용자 ID를 찾을 수 없습니다: " + userId));

        List<WorkHistory> workHistoryList = workHistoryRepository.findByUserId(userId);

        List<String> jobs = workHistoryList.stream()
                .map(workHistory -> workHistory.getJob().getJobName()) // jobName만 추출
                .collect(Collectors.toList());

            Resume resume = resumeRepository.findByUserId(userId)
                    .orElse(null);

            if (resume == null) {
                return ResumeDetailDTO.builder()
                        .userName(byIdWbUser.getName())
                        .jobPoint(byIdWbUser.getJobPoint())
                        .phone(byIdWbUser.getPhone())
                        .addrCity(byIdWbUser.getAddrCity())
                        .addrProvince(byIdWbUser.getAddrProvince())
                        .userIntro("")
                        .userImg("")
                        .resumeEmail("")
                        .jobList(jobs)
                        .build();
            }

            return ResumeDetailDTO.builder()
                    .userName(resume.getWbUser().getName())
                    .jobPoint(resume.getWbUser().getJobPoint())
                    .phone(resume.getWbUser().getPhone())
                    .addrCity(resume.getWbUser().getAddrCity())
                    .addrProvince(resume.getWbUser().getAddrProvince())
                    .userIntro(resume.getUserIntro())
                    .userImg(resume.getUserImg())
                    .resumeEmail(resume.getResumeEmail())
                    .jobList(jobs)
                    .build();
    }

}
