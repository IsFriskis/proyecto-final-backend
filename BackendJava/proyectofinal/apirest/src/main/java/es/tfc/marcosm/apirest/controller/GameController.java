package es.tfc.marcosm.apirest.controller;

import es.tfc.marcosm.apirest.mapper.GameMapperTO;
import es.tfc.marcosm.apirest.mapper.RankingMapperTO;
import es.tfc.marcosm.apirest.to.GameTO;
import es.tfc.marcosm.apirest.to.RankingTO;
import es.tfc.marcosm.domain.service.GameServiceInterface;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.formula.functions.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
    @Autowired
    private final GameServiceInterface gameService;

    @Autowired
    private final GameMapperTO gameMapper;

    @Autowired
    private final RankingMapperTO rankingMapperTO;

    @GetMapping(value = "/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("GameController Up", getHeader(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<GameTO>> selectAllGames(){
        List<GameTO> games = gameMapper.toTOList(gameService.selectAllGames());
        return new ResponseEntity<>(games, getHeader(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/ranking")
    public ResponseEntity<List<RankingTO>> rankingGames(){
        List<RankingTO> games = rankingMapperTO.toTOList(gameService.rankingGames());
        return new ResponseEntity<>(games, getHeader(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}")
    public GameTO selectGameById(@PathVariable Integer id){
        return gameMapper.toTO(gameService.selectGameById(id));
    }

    @PostMapping(value = "/create")
    public GameTO createGame(@RequestBody GameTO gameTO){
        return gameMapper.toTO(gameService.createGame(gameMapper.toDTO(gameTO)));
    }

    @PutMapping(value = "/update/{id}")
    public GameTO updateGame(@PathVariable Integer id, @RequestBody GameTO gameTO){
        return gameMapper.toTO(gameService.updateGame(id, gameMapper.toDTO(gameTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteGame(@PathVariable Integer id){
        return gameService.deleteGame(id);
    }

    @GetMapping(value = "/{userId}")
    public Integer selectGamesAmountByUserId(@PathVariable String userId){
        return gameService.selectGamesAmountByUserId(userId);
    }



    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");
        headers.add("Access-Control-Allow-Origin"," http://localhost:3000");
        return headers;
    }
}
