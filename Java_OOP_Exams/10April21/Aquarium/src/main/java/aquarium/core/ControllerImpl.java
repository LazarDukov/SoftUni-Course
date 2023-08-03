package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium newAquarium = null;
        if (!aquariumType.equals("FreshwaterAquarium") && !aquariumType.equals("SaltwaterAquarium")) {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        switch (aquariumType) {
            case "FreshwaterAquarium":
                newAquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                newAquarium = new SaltwaterAquarium(aquariumName);
                break;
        }
        aquariums.add(newAquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration newDecoration = decorations.findByType(decorationType);

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        if (newDecoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        aquarium.addDecoration(newDecoration);
        decorations.remove(newDecoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        Fish fish = null;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        if (!aquarium.getClass().getSimpleName().substring(0, 5).equals(fishType.substring(0, 5))) {
            throw new IllegalArgumentException(WATER_NOT_SUITABLE);
        }
        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishName, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        double priceOfDecorations = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        double priceOfFish = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double totalPriceOfAquarium = priceOfFish + priceOfDecorations;
        return String.format(VALUE_AQUARIUM, aquariumName, totalPriceOfAquarium);
    }

    @Override
    public String report() {
        return aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
