package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class RecipeServicesImplTest {

    RecipeServicesImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServicesImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesSet = new HashSet<>();
        recipesSet.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipesSet);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);

    }
}