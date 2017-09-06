package org.blackc.blog.core.mapper.data;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.lang3.RandomStringUtils;
import org.blackc.blog.core.dto.ArticleDto;
import org.blackc.blog.core.dto.CategoryDto;
import org.blackc.blog.core.dto.ChannelDto;
import org.blackc.blog.core.dto.LabelDto;

/**
 * @author heyx
 */
public class MockData {

    private static final Random RANDOM_NUM = new Random(System.currentTimeMillis());

    public static ArticleDto makeArticleDto() {
        return ArticleDto.builder()
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

    private static Set<LabelDto> makeLabelDtos() {
        Set<LabelDto> labelDtos = new LinkedHashSet<>();
        for (int i = 0; i < RANDOM_NUM.nextInt(10); i++) {
            labelDtos.add(makeLabelDto());
        }
        return labelDtos;
    }

    private static LabelDto makeLabelDto() {
        return LabelDto.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .build();
    }

    private static SortedSet<CategoryDto> makeCategoryDtos() {
        SortedSet<CategoryDto> categoryDtos = new TreeSet<>();
        for (int i = 0; i < RANDOM_NUM.nextInt(10); i++) {
            categoryDtos.add(makeCategoryDto());
        }
        return categoryDtos;
    }

    private static CategoryDto makeCategoryDto() {
        return CategoryDto.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .build();
    }

    private static ChannelDto makeChannel() {
        return ChannelDto.builder()
            .id(RANDOM_NUM.nextLong())
            .name(randomString(10))
            .description(randomString(50))
            .build();
    }

    private static String randomString(Integer length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
