package me.gumenny.githubler.data.mappers;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import me.gumenny.githubler.data.entity.RepoEntity;
import me.gumenny.githubler.domain.model.Repo;

import static junit.framework.Assert.assertEquals;

/**
 * Created by arkadius on 8/31/17.
 */

public class RepoMapperTest {

    public static final String REPO_CREATED_AT = "2017";
    public static final String REPO_ID = "1";
    public static final String REPO_NAME = "name";
    private Mapper<RepoEntity, Repo> repoMapper;

    @Before
    public void setUp() {
        repoMapper = new MapperFactory().getRepoMapper();
    }

    @Test
    public void testTransformRepo() {
        RepoEntity entity = createRepoEntity();
        Repo repo = repoMapper.transform(entity);
        assertEquals(repo.getId(), REPO_ID);
        assertEquals(repo.getName(), REPO_NAME);
        assertEquals(repo.getCreatedAt(), REPO_CREATED_AT);
    }

    private RepoEntity createRepoEntity() {
        RepoEntity repoEntity = new RepoEntity();
        repoEntity.setId(REPO_ID);
        repoEntity.setCreatedAt(REPO_CREATED_AT);
        repoEntity.setName(REPO_NAME);
        return repoEntity;
    }
}
