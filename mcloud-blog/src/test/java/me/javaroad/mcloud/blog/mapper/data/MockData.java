package me.javaroad.mcloud.blog.mapper.data;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import me.javaroad.mcloud.blog.dto.response.CategoryResponse;
import me.javaroad.mcloud.blog.dto.response.LabelResponse;
import me.javaroad.mcloud.blog.dto.response.ChannelResponse;
import org.apache.commons.lang3.RandomStringUtils;
import me.javaroad.mcloud.blog.dto.response.ArticleResponse;

/**
 * @author heyx
 */
public class MockData {

    private static final Random RANDOM_NUM = new Random(System.currentTimeMillis());

    public static ArticleResponse makeArticleDto() {
        return ArticleResponse.builder()
            .id(RANDOM_NUM.nextLong())
            .title(randomString(10))
            .content(randomString(100))
            .seoTitle(randomString(20))
            .seoKeywords(randomString(50))
            .seoDescription(randomString(100))
            .channel(makeChannel())
            .categories(makeCategoryDtos())
            .labels(makeLabelDtos())
            .build();
    }

    private static Set<LabelResponse> makeLabelDtos() {
        Set<LabelResponse> labelResponses = new LinkedHashSet<>();
        for (int i = 0; i < RANDOM_NUM.nextInt(10); i++) {
            labelResponses.add(makeLabelDto());
        }
        return labelResponses;
    }

    private static LabelResponse makeLabelDto() {
        return LabelResponse.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .build();
    }

    private static SortedSet<CategoryResponse> makeCategoryDtos() {
        SortedSet<CategoryResponse> categoryResponses = new TreeSet<>();
        for (int i = 0; i < RANDOM_NUM.nextInt(10); i++) {
            categoryResponses.add(makeCategoryDto());
        }
        return categoryResponses;
    }

    private static CategoryResponse makeCategoryDto() {
        return CategoryResponse.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .build();
    }

    private static ChannelResponse makeChannel() {
        return ChannelResponse.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .description(randomString(50))
            .build();
    }

    private static String randomString(Integer length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
