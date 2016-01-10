package tvless.catalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import tvless.ApiApplication;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiApplication.class)
@WebAppConfiguration
public class CatalogControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TitleRepository titleRepository;

    private List<Title> titleList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).build();

        this.titleRepository.deleteAllInBatch();

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setName("Some movie");
        movie.setOverview("Stuff happened");
        movie.setReleased(new Date());
        titleList.add(titleRepository.save(movie));

        Series series = new Series();
        series.setId(2L);
        series.setName("Some series");
        series.setOverview("Stuff happened");
        series.setReleased(new Date());
        titleList.add(titleRepository.save(series));

        Episode episode = new Episode();
        episode.setId(3L);
        episode.setName("Some episode");
        episode.setOverview("Stuff happened");
        episode.setReleased(new Date());
        titleList.add(titleRepository.save(episode));
    }

    @Test
    public void readMovie() throws Exception {
        Title t = titleList.get(0);
        mockMvc.perform(get("/catalog/" + t.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(t.getId().intValue())))
                .andExpect(jsonPath("$.name", is(t.getName())))
                .andExpect(jsonPath("$.type", is(TitleType.MOVIE.toString())))
                .andExpect(jsonPath("$.overview", is(t.getOverview())));
        // TODO: check released
    }

    @Test
    public void readSeries() throws Exception {
        Title t = titleList.get(1);
        mockMvc.perform(get("/catalog/" + t.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(t.getId().intValue())))
                .andExpect(jsonPath("$.name", is(t.getName())))
                .andExpect(jsonPath("$.type", is(TitleType.SERIES.toString())))
                .andExpect(jsonPath("$.overview", is(t.getOverview())));
        // TODO: check released
    }

    @Test
    public void readEpisode() throws Exception {
        Title t = titleList.get(2);
        mockMvc.perform(get("/catalog/" + t.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(t.getId().intValue())))
                .andExpect(jsonPath("$.name", is(t.getName())))
                .andExpect(jsonPath("$.type", is(TitleType.EPISODE.toString())))
                .andExpect(jsonPath("$.overview", is(t.getOverview())));
        // TODO: check released
    }
    @Test
    public void titleNotFound() throws Exception {
        mockMvc.perform(get("/catalog/9"))
                .andExpect(status().isNotFound());
    }

}