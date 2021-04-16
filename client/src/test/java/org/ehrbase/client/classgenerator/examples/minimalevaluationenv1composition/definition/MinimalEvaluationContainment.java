package org.ehrbase.client.classgenerator.examples.minimalevaluationenv1composition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class MinimalEvaluationContainment extends Containment {
  public SelectAqlField<MinimalEvaluation> MINIMAL_EVALUATION = new AqlFieldImp<MinimalEvaluation>(MinimalEvaluation.class, "", "MinimalEvaluation", MinimalEvaluation.class, this);

  public SelectAqlField<Double> QUANTITY_MAGNITUDE = new AqlFieldImp<Double>(MinimalEvaluation.class, "/data[at0001]/items[at0002]/value|magnitude", "quantityMagnitude", Double.class, this);

  public SelectAqlField<String> QUANTITY_UNITS = new AqlFieldImp<String>(MinimalEvaluation.class, "/data[at0001]/items[at0002]/value|units", "quantityUnits", String.class, this);

  public SelectAqlField<NullFlavour> QUANTITY_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(MinimalEvaluation.class, "/data[at0001]/items[at0002]/null_flavour|defining_code", "quantityNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(MinimalEvaluation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(MinimalEvaluation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(MinimalEvaluation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private MinimalEvaluationContainment() {
    super("openEHR-EHR-EVALUATION.minimal.v1");
  }

  public static MinimalEvaluationContainment getInstance() {
    return new MinimalEvaluationContainment();
  }
}
