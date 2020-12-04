package org.ehrbase.client.classgenerator.examples.coronaanamnesecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.List;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.shareddefinition.MathFunction;

@Entity
@OptionFor("INTERVAL_EVENT")
public class GeschichteHistorieBeliebigesEreignisIntervalEvent implements GeschichteHistorieBeliebigesEreignisChoice {
  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/Geschichte
   */
  @Path("/data[at0003]/items[at0004]")
  private List<GeschichteHistorieGeschichteElement> geschichte;

  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/Strukturierte Angabe
   */
  @Path("/data[at0003]/items[at0006]")
  private List<Cluster> strukturierteAngabe;

  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/time
   */
  @Path("/time|value")
  private TemporalAccessor timeValue;

  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/width
   */
  @Path("/width|value")
  private TemporalAmount widthValue;

  /**
   * Bericht/Geschichte/Historie/Beliebiges Ereignis/math_function
   */
  @Path("/math_function|defining_code")
  private MathFunction mathFunctionDefiningCode;

  public void setGeschichte(List<GeschichteHistorieGeschichteElement> geschichte) {
     this.geschichte = geschichte;
  }

  public List<GeschichteHistorieGeschichteElement> getGeschichte() {
     return this.geschichte ;
  }

  public void setStrukturierteAngabe(List<Cluster> strukturierteAngabe) {
     this.strukturierteAngabe = strukturierteAngabe;
  }

  public List<Cluster> getStrukturierteAngabe() {
     return this.strukturierteAngabe ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
  }

  public void setWidthValue(TemporalAmount widthValue) {
     this.widthValue = widthValue;
  }

  public TemporalAmount getWidthValue() {
     return this.widthValue ;
  }

  public void setMathFunctionDefiningCode(MathFunction mathFunctionDefiningCode) {
     this.mathFunctionDefiningCode = mathFunctionDefiningCode;
  }

  public MathFunction getMathFunctionDefiningCode() {
     return this.mathFunctionDefiningCode ;
  }
}
